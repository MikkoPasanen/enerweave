import { useState } from "react";

// Components
import Footer from "../components/Footer";
import Select from "react-select";
import CustomStepper from "../components/Stepper";

// Styles & assets
import "../style/css/selectHardwarePage.css";
import "bootstrap-icons/font/bootstrap-icons.css";

const SelectHardwarePage = () => {

    const [selectedHardwares, setSelectedHardwares] = useState([])

    const heatPumps = [
        { value: "Pumppu1", label: "Pumppu 1" },
        { value: "Pumppu2", label: "Pumppu 2" },
        { value: "Pumppu3", label: "Pumppu 3" },
        { value: "Pumppu4", label: "Pumppu 4" },
    ]

    const solarPanels = [
        { value: "Paneeli1", label: "Paneeli 1" },
        { value: "Paneeli2", label: "Paneeli 2" },
        { value: "Paneeli3", label: "Paneeli 3" },
        { value: "Paneeli4", label: "Paneeli 4" },
    ];

    const data = (item) => {
        console.log(item)
    }

    const groupedOptions = [
        {
            label: "Heat Pumps",
            options: heatPumps
        },
        {
            label: "Solar Panels",
            options: solarPanels
        }
    ];

    const formatGroupLabel = data => (
        <div style={{display: "flex"}}>
            <span>{data.label}</span>
            <span className="select-badge">{data.options.length}</span>
        </div>
    )

    return (
        <>
            <CustomStepper activeStep={0} />
            <h3>
                Select the appliances you own or that you are planning to buy:
            </h3>
            <div className="hardware-container">
                <div className="left-side">
                    <h3>Filter by category</h3>
                    <div className="checkbox-container">
                        <div className="filter-checkbox">
                            <input type="checkbox" />
                            <p>Heat pump</p>
                        </div>
                        <div className="filter-checkbox">
                            <input type="checkbox" />
                            <p>Wallbox</p>
                        </div>
                        <div className="filter-checkbox">
                            <input type="checkbox" />
                            <p>Solar panel</p>
                        </div>
                        <div className="filter-checkbox">
                            <input type="checkbox" />
                            <p>Energy meter</p>
                        </div>
                    </div>
                    <Select
                        className="dropdown"
                        options={groupedOptions}
                        formatGroupLabel={formatGroupLabel}
                        placeholder="Search for appliances"
                        onChange={(selectedOption) => setSelectedHardwares([...selectedHardwares, selectedOption.label])}
                    />
                </div>
                <div className="right-side">
                    {selectedHardwares.map((hardware, index) => (
                        <div key={index} className="selected-hardware">
                            <p>{hardware}</p>
                            <button className="bi bi-trash" onClick={() => {
                                const newHardwares = selectedHardwares.filter((_, i) => i !== index);
                                setSelectedHardwares(newHardwares);
                            }} />
                        </div>
                    ))}
                </div>
            </div>
            <Footer />
        </>
    );
}

export default SelectHardwarePage;
