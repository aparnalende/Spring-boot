import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import AddEmployee from "./components/AddEmployee";
import EmployeeList from "./components/EmployeeList";
import Navbar from "./components/Navbar";
import SignIn from "./components/SignIn";
import UpdateEmployee from "./components/UpdateEmployee";
import "bootstrap/dist/css/bootstrap.min.css";
function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          {/* <Route index element={<EmployeeList />} /> */}
          {/* <Route path="/" element={<SignIn />}></Route> */}
          <Route path="/" element={<EmployeeList />}></Route>
          <Route path="/employeeList" element={<EmployeeList />} />
          <Route path="/addEmployee" element={<AddEmployee />} />
          <Route path="/editEmployee/:id" element={<UpdateEmployee />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App


// import React, { useState, useEffect, useCallback } from "react";
// import { useDispatch, useSelector } from "react-redux";
// import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";

// import "bootstrap/dist/css/bootstrap.min.css";
// import "./App.css";

// import SignUp from "./components/SignUp";
// import Home from "./components/Home";
// import Profile from "./components/profile.component";
// import BoardUser from "./components/board-user.component";
// import BoardModerator from "./components/board-moderator.component";
// import BoardAdmin from "./components/board-admin.component";
// import SignIn from "./components/SignIn";
// import { logout } from "./slices/auth";

// import EventBus from "./common/EventBus";

// const App = () => {
//   const [showModeratorBoard, setShowModeratorBoard] = useState(false);
//   const [showAdminBoard, setShowAdminBoard] = useState(false);

//   const { user: currentUser } = useSelector((state) => state.auth);
//   console.log("Current user",currentUser)
//   const dispatch = useDispatch();

//   const logOut = useCallback(() => {
//     dispatch(logout());
//   }, [dispatch]);

//   useEffect(() => {
//     if (currentUser) {
//       setShowModeratorBoard(currentUser.roles.includes("moderator"));
//       setShowAdminBoard(currentUser.roles.includes("admin"));
//     } else {
//       setShowModeratorBoard(false);
//       setShowAdminBoard(false);
//     }

//     EventBus.on("logout", () => {
//       logOut();
//     });

//     return () => {
//       EventBus.remove("logout");
//     };
//   }, [currentUser, logOut]);

//   return (
//     <Router>
//       <div>
//         <nav className="navbar navbar-expand navbar-dark bg-dark">
//           <Link to={"/"} className="navbar-brand">
//             Demo
//           </Link>
//           <div className="navbar-nav mr-auto">
//             <li className="nav-item">
//               <Link to={"/home"} className="nav-link">
//                 Home
//               </Link>
//             </li>

//             {/* {showModeratorBoard && (
//               <li className="nav-item">
//                 <Link to={"/mod"} className="nav-link">
//                   Moderator Board
//                 </Link>
//               </li>
//             )} */}

//             {showAdminBoard && (
//               <li className="nav-item">
//                 <Link to={"/admin"} className="nav-link">
//                   Admin Board
//                 </Link>
//               </li>
//             )}

//             {/* {currentUser && (
//               <li className="nav-item">
//                 <Link to={"/user"} className="nav-link">
//                   User
//                 </Link>
//               </li>
//             )} */}
//           </div>

//           {currentUser ? (
//             <div className="navbar-nav ml-auto">
//               <li className="nav-item">
//                 <Link to={"/profile"} className="nav-link">
//                   {currentUser.username}
//                 </Link>
//               </li>
//               <li className="nav-item">
//                 <a href="/login" className="nav-link" onClick={logOut}>
//                   LogOut
//                 </a>
//               </li>
//             </div>
//           ) : (
//             <div className="navbar-nav ml-auto">
//               <li className="nav-item">
//                 <Link to={"/login"} className="nav-link">
//                   Login
//                 </Link>
//               </li>

//               <li className="nav-item">
//                 <Link to={"/register"} className="nav-link">
//                   Sign Up
//                 </Link>
//               </li>
//             </div>
//           )}
//         </nav>

//         <div className="container mt-3">
//           <Routes>
//             <Route path="/" element={<Home />} />
//             <Route path="/home" element={<Home />} />
//             <Route path="/login" element={<SignIn />} />
//             <Route path="/register" element={<SignUp />} />
//             <Route path="/profile" element={<Profile />} />
//             {/* <Route path="/user" element={<BoardUser />} /> */}
//             {/* <Route path="/mod" element={<BoardModerator />} /> */}
//             <Route path="/admin" element={<BoardAdmin />} />
//           </Routes>
//         </div>
//       </div>
//     </Router>
//   );
// };

// export default App;
