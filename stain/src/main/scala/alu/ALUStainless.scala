import chisel3._

import stainless.lang._
import stainless.annotation._
import stainless.collection._

import chiseltest._

import alu.Adder

case class ALUStainless(@extern dut: Adder) {
  @extern
  def adder(a: BigInt, b: BigInt): BigInt = {
    dut.io.in1.poke(a.U)
    dut.io.in2.poke(b.U)
    dut.io.out.peekInt()
  }
  def prop(a: BigInt, b: BigInt): BigInt = {
    require(0 <= a && a <= 10 && 0 <= b && b <= 10)
    adder(a, b)
  } ensuring (res => res == a + b)
}

case class HelloStainless(k: Int) {
  def max(x: Int, y: Int): Int = {
    require(0 <= x && 0 <= y)
    val d = x - y
    if (d > 0) x
    else y
  } ensuring (res => res == (if (x < y) y else x))
}
