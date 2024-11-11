import { Link } from "react-router-dom";

// Components
import Navbar from "../components/Navbar";
import Footer from "../components/Footer";

// Styles and assets
import "../style/css/homePage.css";
import logo from "../assets/SPINE-LOGO.png";

const HomePage = () => {
  return (
    <>
      <Navbar />
      <h3 className="homepage-h3">Welcome to find the best energy solution</h3>
      <div className="homepage-container">
        <div className="homepage-inner">
          <img src={logo} alt="spine logo" />
          <div className="homepage-info">
            <p>
              Lorem ipsum dolor sit amet consectetur adipisicing elit. Earum
              facilis veritatis totam, temporibus sint pariatur perspiciatis
              eius tempora labore accusamus placeat aliquid, reprehenderit
              laudantium. Sequi fugiat asperiores dolorum quasi?
            </p>
            <Link to="/select-hardware">
              <button>Start</button>
            </Link>
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default HomePage;
