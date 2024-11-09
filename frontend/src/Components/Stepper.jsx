/* eslint-disable react/prop-types */

import { Step, Stepper } from "react-form-stepper";
import "../style/css/stepper.css"

const CustomStepper = ({ activeStep }) => {
    return (
        <>
            <Stepper
                activeStep={activeStep}
                styleConfig={{
                    activeBgColor: "#0AA3EB",
                    completedBgColor: "#1B335F",
                    inactiveBgColor: "#BDBDBD",
                    completedTextColor: "#FFFFFF",
                    inactiveTextColor: "#000000",
                }}
            >
                <Step className="step" label="Select appliances" />
                <Step label="Our recommendations" />
                <Step label="Your final choice" />
            </Stepper>
        </>
    );
};

export default CustomStepper;
