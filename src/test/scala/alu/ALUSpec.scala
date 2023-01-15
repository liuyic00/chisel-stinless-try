package alu

import chisel3._
import chiseltest._
import org.scalatest.freespec.AnyFreeSpec
import chisel3.experimental.BundleLiterals._

class ALUSpec extends AnyFreeSpec with ChiselScalatestTester {
  "Adder should pass test" in {
    test(new Adder) { dut =>
      dut.io.in1.poke(1.U)
      dut.io.in2.poke(1.U)
      dut.io.out.expect(2.U)
    }
  }
}
