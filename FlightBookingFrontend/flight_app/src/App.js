import Home from './components/home';
import Navbar from './components/Navbar';
import Login from './components/Login';
import Signup from './components/Signup';
import { useEffect } from 'react';
import About from './components/About';
import Booking from './components/Booking';


import {
  BrowserRouter as Router,
  Route,
  Routes
} from "react-router-dom";


function App() {
  //This works for log out the user when user close the window.
  useEffect(() => {
    const handleTabClose = event => {
      localStorage.clear();
      return (event.returnValue =
        'Are you sure you want to exit?');
    };

    window.addEventListener('beforeunload', handleTabClose);

    return () => {
      window.removeEventListener('beforeunload', handleTabClose);
    };
  }, []);


  return (
    <>
      {/* All states will be available to all components between this NoteState. */}
      <Router>
        <Navbar />
        <div  style={{marginTop:"3.5rem"}}>
          <Routes>
            <Route exact path='/' element={<Home />} ></Route>

            <Route exact path='/login' element={<Login />} ></Route>

            <Route exact path='/signup' element={<Signup />} ></Route>

            <Route exact path='/about' element={<About />}  ></Route>

            <Route exact path='/booking' element={<Booking />} ></Route>

            <Route path="*" element={<MatchAllRoute />} />

          </Routes>
        </div>
      </Router>
    </>
  );
}

function MatchAllRoute() {
  return <h2>The requested page does not exist</h2>;
}

export default App;