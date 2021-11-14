package com.example.desginpatternsexample.decorator

fun main() {
    val sandwich = BurgerSandwich(CheeseSandwich(BasicSandwich()))
    println(sandwich.getDescription())
    println(sandwich.getCost())
}

interface SandwichInterface {
    fun getDescription(): String
    fun getCost(): Double
}

class BasicSandwich : SandwichInterface {

    override fun getDescription(): String {
        return "Sandwich"
    }

    override fun getCost(): Double {
        return 5.0
    }

}

open class SandwichDecorator(private var sandwichInterface: SandwichInterface) : SandwichInterface {
    override fun getDescription(): String {
        return sandwichInterface.getDescription()
    }

    override fun getCost(): Double {
        return sandwichInterface.getCost()
    }

}

class BurgerSandwich(sandwichInterface: SandwichInterface) : SandwichDecorator(sandwichInterface) {
    override fun getDescription(): String {
        return super.getDescription() + " Burger"
    }

    override fun getCost(): Double {
        return super.getCost() + 40.0
    }
}

class CheeseSandwich(sandwichInterface: SandwichInterface) : SandwichDecorator(sandwichInterface) {
    override fun getDescription(): String {
        return super.getDescription() + " Cheese"
    }

    override fun getCost(): Double {
        return super.getCost() + 10.0
    }

}