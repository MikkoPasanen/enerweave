import { Link } from "react-router-dom";
import "../style/css/navbar.css";

const Navbar = () => {
  return (
    <>
      <h1>
        <span>Ener</span>Weave
      </h1>
      <nav className="navbar">
        <div className="nav-container">
          <div className="links">
            <Link to="/">
              <a>Home</a>
            </Link>
            <p>What is EnerWeave?</p>
            <p>Instructions</p>
            <p>Language</p>
          </div>
        </div>
      </nav>
    </>
  );
};

export default Navbar;
