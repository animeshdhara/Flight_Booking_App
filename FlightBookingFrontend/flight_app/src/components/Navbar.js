import React, { useContext, useEffect } from 'react'
import { Link, useLocation, useNavigate } from 'react-router-dom'
import { toast } from 'react-toastify';

function Navbar(props) {
    let location = useLocation();
    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.clear();
        toast.success("You have successfully logged out!");
        navigate("/login");
    }

    useEffect(() => {
        if ( location.pathname !== '/signup' &&  !localStorage.getItem('token')) {
        
            console.log("location : ",location.pathname);
            // props.showAlert("Please login to view your notes.","Error","danger");
            toast.error("Please login!");
            navigate("/login");
        }

    }, [])

    return (
        <>
            <nav className="navbar navbar-expand-lg bg-body-tertiary fixed-top">
                <div className="container-fluid">
                    <Link className="navbar-brand" to="/">Book My Flight</Link>
                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                            <li className="nav-item">
                                <Link className="nav-link active" aria-current="page" to="/">Home</Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link active" aria-current="page" to="/about">About</Link>
                            </li>
                        </ul>
                    </div>
                    {
                      localStorage.getItem('token') && <button onClick={handleLogout} className='btn btn-primary'>Logout</button>

                    }
                </div>
            </nav>

        </>
    )
}

export default Navbar