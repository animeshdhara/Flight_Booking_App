import React from 'react'
import { Link } from 'react-router-dom'

export default function FlightSearchResult(props) {
  const handleBooking = ()=>{
    console.log("before set: ",props.searchFlight);
    localStorage.setItem('flight',JSON.stringify( props.searchFlight));
}
  return (
<>
    
    <div className="card" style={{width: '18rem'}}>
    <div className="card-body">
      <h5 className="card-title">{props.searchFlight.departureCity.toUpperCase() } to {props.searchFlight.arrivalCity.toUpperCase()}</h5>
      <h6 className="card-subtitle mb-2 text-body-secondary">{props.searchFlight.airline}</h6>
      <p className="card-text">{props.searchFlight.arrivalDate}</p>
      <div className="price">Only <i className="fa fa-inr"/>{props.searchFlight.costPerSeat - (props.searchFlight.costPerSeat * props.searchFlight.discount)}</div>
      <Link onClick={handleBooking} className='card-link' to={"/booking"}>Book</Link>
    </div>
  </div>
  </>
  )
}
