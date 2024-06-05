import React, { useState,useContext } from 'react'
import { useNavigate,Link } from 'react-router-dom'
import {toast} from 'react-toastify';

export default function Login () {
    const loginUrl ='http://localhost:5000/user/login';
    console.log("loging url: ",loginUrl);
    const [credential, setcredential] = useState({ email: "", password: "" });
    const navigate = useNavigate();

    const handleChange = (e) => {
        setcredential((prev) => ({ ...prev, [e.target.name]: e.target.value }));
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log("Credential : ", credential);

        const response = await fetch(loginUrl, {
            method: "POST", // *GET, POST, PUT, DELETE, etc.
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ email: credential.email, password: credential.password })
        });
        const json = await response.json();
        console.log("response: ",response);
        if (json.success) {
            console.log("Login token is : ", json.jwtToken);
            //Save the token into local storage and redirect.
            localStorage.setItem('token', json.jwtToken);
            localStorage.setItem('userid', json.id);
            localStorage.setItem('username', json.name);
            
            // props.showAlert("Logged in successfully.", "Success", "success");
            toast.success("Logged in successfully");
            navigate("/");
        }
        //Loggin unsuccessful
        else {
            // props.showAlert("Invalid credentials!", "Error", "danger");
            toast.error("Invalid credentials!");

        }
        // setcredential({ email: "", password: ""})
    }
    // console.log("login : ", loginUrl);

    return (
        <div className='container'>
            {/* <h2 style={{color:mode === 'dark'?'white':'black'}}>Login to view your notes.</h2> */}
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input type="email" className="form-control" id="email" name="email" aria-describedby="emailHelp" onChange={handleChange}/>
                    <div id="emailHelp" className="form-text" >We'll never share your email with anyone else.</div>
                </div>
                <div className="mb-3" >
                    <label htmlFor="password" className="form-label"  >Password</label>
                    <input autoComplete='off' type="password" className="form-control" id="password" name="password" onChange={handleChange} />
                </div>
                <button type="submit" className="btn btn-primary" style={{marginLeft : '10px'}}>Submit</button>
                <Link to= "/signup"> Create new account </Link>
            </form>
        </div>
    )
}
