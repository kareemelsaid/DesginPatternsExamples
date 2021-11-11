package com.example.desginpatternsexample.strategy

fun main(){
    val calculateManagerSalary = CalculateSalaryController(CalculateManagerSalary())
    println(calculateManagerSalary.calculate(20000))

    val calculateEmployeeSalary = CalculateSalaryController(CalculateEmployeeSalary())
    println(calculateEmployeeSalary.calculate(10000))
}

interface CalculateSalaryInterface{
    fun calculate(salary:Int):Int
}

class CalculateManagerSalary:CalculateSalaryInterface{
    override fun calculate(salary: Int): Int {
        return salary * 30
    }
}

class CalculateEmployeeSalary:CalculateSalaryInterface{
    override fun calculate(salary: Int): Int {
        return salary * 20
    }
}

class CalculateSalaryController(private val calculateSalaryInterface: CalculateSalaryInterface){
    fun calculate(salary:Int):Int{
        return calculateSalaryInterface.calculate(salary)
    }
}