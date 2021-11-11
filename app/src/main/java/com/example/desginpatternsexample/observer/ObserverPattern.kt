package com.example.desginpatternsexample.observer


fun main(){
    val passengerOne = Passenger("Ahmed")
    val passengerTwo = Passenger("Kareem")
    val passengerThree = Passenger("Abdelrahman")

    val bus = Bus("Nasr City Bus")
    bus.subscribe(passengerOne)
    bus.subscribe(passengerTwo)
    bus.subscribe(passengerThree)

    bus.isArrived(true)
}
interface PassengerObserverInterface {
    fun update(message:String)
}

interface BusSubjectInterface {
    fun subscribe(passengerObserver:PassengerObserverInterface)
    fun unsubscribe(passengerObserver:PassengerObserverInterface)
    fun notifyAllPassengers()
}

class Bus( var name : String = "",var arrived : String = ""): BusSubjectInterface{
    private var arrayListPassengerObserver:ArrayList<PassengerObserverInterface> = ArrayList()

    override
    fun subscribe(passengerObserver:PassengerObserverInterface){
        arrayListPassengerObserver.add(passengerObserver)
    }

    override
    fun unsubscribe(passengerObserver:PassengerObserverInterface){
        arrayListPassengerObserver.remove(passengerObserver)
    }

    override
    fun notifyAllPassengers(){
        arrayListPassengerObserver.map{
            it.update(arrived)
        }
    }

    fun isArrived(arrive:Boolean){
        arrived = if(arrive){
            "$name arrived"
        }else{
            "$name not arrived"
        }
        notifyAllPassengers()
    }
}

class Passenger(var name : String) : PassengerObserverInterface {
    override fun update(message: String) {
        println("$name have new notification ->  $message")
    }

}