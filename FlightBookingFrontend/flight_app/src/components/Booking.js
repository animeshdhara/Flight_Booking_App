import React from 'react'
import {useState} from 'react';
import { Link,useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify';

export default function Booking() {
  const newflight = JSON.parse(localStorage.getItem('flight'));
  const [flight, setFlight] = useState(newflight);

  
  const navigate = useNavigate();
  const handleBooking = async ()=>{
    console.log("handle booking main");
    const userId = localStorage.getItem('userid');
    const flightId = flight.flightId;



    const date = "2024-04-24";// TODO

    console.log("date ",date);
    console.log("fight id ",flightId);
    console.log("user id" ,userId);

    const loginUrl = 'http://localhost:5000/api/booking/add';
    const response = await fetch(loginUrl, {
      method: "POST", // *GET, POST, PUT, DELETE, etc.
      headers: {
          "Content-Type": "application/json",
          "Authorization": "Bearer "+localStorage.getItem('token')
      },
      body: JSON.stringify({ userId: userId, flightId:flightId, bookingDate:date})//TODO
  });
  const json = await response.json();
  console.log("response: ",json);
  if(json.bookingId){
    toast.success("Flight booking successfull!")
  }
  else{
    toast.error(json.message)
  }
  setTimeout(() => {
    navigate("/")
    
  }, 1000);
  }

  return (
    <div className="container">
        <h1>Enter booking details....</h1>
        <div className="card" style={{width: '40rem', height:'30rem'}}>
    <div className="card-body">
      <h5 className="card-title">{flight.departureCity.toUpperCase() } to {flight.arrivalCity.toUpperCase()}</h5>
      <h6 className="card-subtitle mb-2 text-body-secondary">{flight.airline}</h6>
      <p className="card-text">{flight.arrivalDate}</p>
      <div className="price"><i className="fa fa-inr"/>{flight.costPerSeat - (flight.costPerSeat * flight.discount)}</div>
      <Link onClick={handleBooking} className='card-link' to={"/booking"}>Confirm booking</Link>
    </div>
  </div>
    </div>
  )
}
