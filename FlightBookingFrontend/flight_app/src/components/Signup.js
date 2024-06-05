import React, { useState,useContext } from 'react'
import { useNavigate,Link } from 'react-router-dom'
import {toast} from 'react-toastify'

export default function Signup(props) {
  const signupUrl = 'http://localhost:5000/user/sign-up'
  console.log("signup url : ", signupUrl);

  const [credential, setcredential] = useState({ name: "", email: "", password: "", cpassword: "" });
  const navigate = useNavigate();

  const handleChange = (e) => {
    setcredential((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    // console.log("Credential : ", credential);
    if (credential.password !== credential.cpassword) {
        // props.showAlert("The password and confirmation password do not match.","Error","danger");
        toast.error("Password and confirmation password should be same!");
    }
    else {
      const response = await fetch(signupUrl, {
        method: "POST", // *GET, POST, PUT, DELETE, etc.
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ name: credential.name, email: credential.email, password: credential.password })
      });
      const json = await response.json();
      if (json && json.id) {
        toast.success("Account Created Successfully!");
        localStorage.setItem('userId',json.id);
        navigate("/");
      }
      //Loggin unsuccessful
      else {
        // props.showAlert("Sorry a user with this email already exists!", "Error", "danger");
        toast.error("Sorry a user with this email already exists!");
      }
      // setcredential({ email: "", password: ""})
    }
  }  
  return (
    <div className='container'>
      <h2 >Create an account to use web chat</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="name" className="form-label" >Name </label>
          <input type="text" className="form-control" id="name" name="name" aria-describedby="emailHelp" onChange={handleChange} minLength={3} required />
        </div>

        <div className="mb-3">
          <label htmlFor="email" className="form-label" >Email address</label>
          <input type="email" className="form-control" id="email" name="email" aria-describedby="emailHelp" onChange={handleChange} required />
          <div id="emailHelp" className="form-text" >We'll never share your email with anyone else.</div>
        </div>

        <div className="mb-3">
          <label htmlFor="password" className="form-label" >Password</label>
          <input type="password" className="form-control" id="password" name="password" onChange={handleChange} minLength={5} required />
        </div>

        <div className="mb-3">
          <label htmlFor="cpassword" className="form-label" >Confirm Password</label>
          <input type="password" className="form-control" id="cpassword" name="cpassword" onChange={handleChange} required />
        </div>

        <button type="submit" className="btn btn-primary">Submit</button>
        <Link to= "/login"> Log IN </Link>
      </form>
    </div>
  )
}
