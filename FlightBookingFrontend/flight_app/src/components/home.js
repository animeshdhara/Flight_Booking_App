import React from 'react'
import { useState, useRef, useContext, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import { toast } from 'react-toastify'
import '../CSS/style.css'
import axios from 'axios';
import FlightSearchBar from './FlightSearchBar';
import SpecialDeal from './SpecialDeal';

export default function Home(props) {
    const [specialFlight,setSpecialFlight] = useState([]);
    const [totalFlight, setTotalFlight] = useState([]);


    const fetchAllFlightUrl = 'http://localhost:5000/api/flight/getall';
    const fetchSpecialFlightUrl = 'http://localhost:5000/api/flight/getspecialdeals';

    useEffect(() => {
        console.log("into use effect");
        console.log("token ",localStorage.getItem('token'));
            console.log("into async");
            fetch(fetchAllFlightUrl, {
                method: "GET", // *GET, POST, PUT, DELETE, etc.
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + localStorage.getItem('token')
                }
            }).then((res)=>{
                    res.json().then((r)=>{
                        setTotalFlight(r);
                    });
            })
            
            fetch(fetchSpecialFlightUrl, {
                method: "GET", // *GET, POST, PUT, DELETE, etc.
                headers: {
                    "Content-Type": "application/json",
                    "Authorization": "Bearer " + localStorage.getItem('token')
                }
            }).then((res)=>{
                res.json().then((r)=>{
                    setSpecialFlight(r);
                });
            })
    },[])


    return (
        <>
            <div id="carouselExampleRide" className="carousel slide" data-bs-ride="true">
                <div className="carousel-inner">
                    <div className="carousel-item active">
                        <img src="/flight4.jpg" className="d-block w-100" alt="..."/>
                    </div>
                    <div className="carousel-item">
                        <img src="/flight2.jpg" className="d-block w-100" alt="..."/>
                    </div>
                    <div className="carousel-item">
                        <img src="/flight5.jpg" className="d-block w-100" alt="..."/>
                    </div>
                    <div className="carousel-item">
                        <img src="/flight1.jpg" className="d-block w-100" alt="..."/>
                    </div>
                    <div className="carousel-item">
                        <img src="/flight3.jpg" className="d-block w-100" alt="..."/>
                    </div>
                </div>
                <button className="carousel-control-prev" style={{color:'black'}} type="button" data-bs-target="#carouselExampleRide" data-bs-slide="prev">
                    <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span className="visually-hidden">Previous</span>
                </button>
                <button className="carousel-control-next" type="button" data-bs-target="#carouselExampleRide" data-bs-slide="next">
                    <span className="carousel-control-next-icon" aria-hidden="true"></span>
                    <span className="visually-hidden" style={{color:'black'}}>Next</span>
                </button>
            </div>

            <div className="search">
                 <FlightSearchBar flightList = {totalFlight} />
            </div>

            <div className="special_deal_container">
                {
                    specialFlight.length > 0 && specialFlight.map((s)=>{
                        return <SpecialDeal specialDeals ={s} key = {s.flightId} />
                    })
                }
            </div>
        </>
    )
}
