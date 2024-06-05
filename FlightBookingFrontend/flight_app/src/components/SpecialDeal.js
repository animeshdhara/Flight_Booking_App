import React from 'react'
import { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import '../CSS/style.css'

export default function SpecialDeal(props) {
    const [minute, setMinute] = useState(props.specialDeals.time);
    const [second, setSecond] = useState(0);

    // console.log("props : ", props.specialDeals);
    const handleTime = ()=>{
        let s = second;
        let m = minute;

        if(s-1 === -1){
            m = m -1;
            s = 59;
        }
        else{
            s = s-1;
        }
        setMinute(m);
        setSecond(s);
    }

    const handleBooking = ()=>{
        localStorage.setItem('flight',JSON.stringify( props.specialDeals));

        console.log("flight in special: ",JSON.parse(localStorage.getItem('flight')));

        console.log("flight ",props.specialDeals);
    }

    useEffect(()=>{
        const interval = setInterval(handleTime , 1000 );

        return () => clearInterval(interval);
    },[second])

    return (
        <>
            <div className="card" style={{width: '18rem', display: minute <0?"none":"inline"}} >
                <img src="/special1.jpg" className="card-img-top" alt="Image loading...."/>
                    <div className="card-body">
                        <h5 className="card-title">{props.specialDeals.departureCity.toUpperCase()} to {props.specialDeals.arrivalCity.toUpperCase()}</h5>
                        <p className="card-text">Special discount for this day! Hurry!!!!</p>
                        <div className="price">Only <i className="fa fa-inr"/>{props.specialDeals.costPerSeat - (props.specialDeals.costPerSeat * props.specialDeals.discount)}</div>
                    </div>
                    <div className="card-body card_time">
                        <Link onClick={handleBooking} to="/booking" className="card-link">Book now</Link>
                        <div className="time">{minute}:{second}</div>
                    </div>
            </div>
        </>
    )
}
