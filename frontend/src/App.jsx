//Pages
import HomePage from "./pages/HomePage";
import SelectHardwarePage from "./pages/SelectHardwarePage";

import {
    Route,
    BrowserRouter as Router,
    Routes
} from "react-router-dom";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/select-hardware" element={<SelectHardwarePage />} />
            </Routes>
        </Router>
    );
};

export default App;
