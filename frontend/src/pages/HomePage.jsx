import { useState } from "react";

// Components
import Footer from "../components/Footer";

// Styles and assets
import "../style/css/homePage.css";
import logo from "../assets/SPINE-LOGO.png";

const HomePage = () => {
    const [text, setText] = useState("");

    const fetchData = async () => {
        try {
            const response = await fetch(
                "http://api-1300198245.eu-north-1.elb.amazonaws.com:8080/api/hello"
            );
            const data = await response.text();
            console.log(data);
            setText(data);
        } catch (error) {
            console.log(error);
        }
    };

    return (
        <>
            <header>
                <h1>
                    <span>Ener</span>Weave
                </h1>
                <h3>Testing out landing page</h3>
                <img src={logo} alt="spine logo" />
                <button onClick={() => fetchData()}>Fetch data!</button>
                <p>{text}</p>
            </header>
            <Footer />
        </>
    );
}

export default HomePage;
