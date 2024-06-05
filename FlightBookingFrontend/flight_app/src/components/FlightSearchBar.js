import React, { useState } from 'react';
import Select from 'react-select';
import '../CSS/style.css'
import {toast} from 'react-toastify';
import FlightSearchResult from './FlightSearchResult';

const FlightSearchBox = (props) => {
  const [toCity, setToCity] = useState('Chose arrival city');
  const [fromCity, setFromCity] = useState('Chose departure city');

  const [searchList, setSearchList] = useState([]);

  const handleChangeToCity = (city) => {
    setToCity(city.label);
  };
  const handleChangeFromCity = (city) => {
    setFromCity(city.label);
  };

  const handleSubmit = async () => {
      console.log("from city: ",fromCity,", to city: ",toCity);

      const fetchByCityUrl = `http://localhost:5000/api/flight/getbycity/${toCity}-${fromCity}`;
      const response = await fetch(fetchByCityUrl, {
        method: "GET", // *GET, POST, PUT, DELETE, etc.
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + localStorage.getItem("token")
        }
    });
    const json = await response.json();
    console.log("booking: ",json);
    if(!json.success){
      toast.error(json.message);
    }
      setSearchList(json);
  };

    const departureCities = props.flightList.reduce((uniqueDepartureCities, flight) => {
      if (!uniqueDepartureCities.some(city => city.label === flight.departureCity)) {
          uniqueDepartureCities.push({ value: flight.flightId, label: flight.departureCity });
      }
      return uniqueDepartureCities;
  }, []);

  const arrivalCities = props.flightList.reduce((uniqueDepartureCities, flight) => {
    if (!uniqueDepartureCities.some(city => city.label === flight.arrivalCity)) {
        uniqueDepartureCities.push({ value: flight.flightId, label: flight.arrivalCity });
    }
    return uniqueDepartureCities;
  }, []);


  const handleSwap = ()=>{
    const temp = fromCity;
    setFromCity(toCity);
    setToCity(temp);
  }

  return (
    <div className='searchBox'>
      
      <Select
        options={departureCities}
        value={fromCity}
        onChange={handleChangeFromCity}
        placeholder = {fromCity}
        className='select'
        id='from'
      />
      <div onClick={handleSwap} className="swap">
        <i onClick={handleSwap} className="fa-solid fa-arrow-right-arrow-left arrow"/>
      </div>

      <Select
        options={arrivalCities}
        value={toCity}
        onChange={handleChangeToCity}
        placeholder = {toCity}
        className='select'
      />
      <button onClick={handleSubmit} className='btn btn-success'>Search</button>
      <div className="special_deal_container">
          {
              searchList.length > 0 && searchList.map((s)=>{
                  return <FlightSearchResult searchFlight ={s} key = {s.flightId} />
              })
          }
      </div>

    </div>
  );
};

export default FlightSearchBox;