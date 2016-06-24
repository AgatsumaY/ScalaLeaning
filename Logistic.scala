class Logistic(val n: Int, val m: Int) {
	val w = Array.fill[Double](m, n)((math.random*2-1)*0.01) //重み
	val b = Array.fill[Double](m)(0.0)
	val wDelta = Array.ofDim[Double](m, n) // 重み修正値
	val bDelta = new Array[Double](m)
	val bTmp = new Array[Double](m)
	val out = Array.ofDim[Double](m)
	val err = Array.ofDim[Double](m)

	//ループ制御
	def loop(n: Int)(body: (Int) => Unit) {
		var i = 0; while (i < n) {body(i); i += 1}
	}

	//Σ計算制御
	def sum(n: Int)(body: (Int) => Double): Double = {
		var i = 0; var s = 0.0; while(i < n) { s+=body(i); i+=1 }; s
	}

	def softmax(x: Array[Double]) { //ソフトマックス関数
		loop(x.length) {i => x(i) = math.exp(x(i)) }
		val s = x.sum
		loop(x.length) {i => x(i) /= s }
	}

	def forward(data: Array[Double]) { //出力計算
		loop(m) { j =>
			out(j) =  sum(n) { i => w(j)(i) * data(i) } + b(j)
		}
		softmax(out)
	}

	def accumDelta(x: Array[Double], t: Array[Double]) { //修正量加算
		loop(m) { j =>
			val err = t(j) - out(j)
			bDelta(j) += err
			loop(n) {i => wDelta(j)(i) += err * x(i) }
		}
	}

	def train(data: Array[Array[Double]], teach: Array[Array[Double]], patN: Int, trainN: Int, batchSize: Int, learnRate: Double) {
		val rate = learnRate / batchSize
		loop(trainN * patN / batchSize) { t => // 学習ループ
			loop(m) { j =>					   // 修正量初期化ループ
				bDelta(j) = 0.0
				loop(n) { i => wDelta(j)(i) = 0.0 }
			}
			loop(batchSize) { i =>				// バッチループ
				val idx = (t * batchSize + i) % patN
				forward(data(idx))
				accumDelta(data(idx), teach(idx))
			}
			loop(m) { j =>						//　修正量適用ループ
				b(j) += rate * bDelta(j)
				loop(n) { i => w(j)(i) += rate * wDelta(j)(i)}
			}
		}
	}

}