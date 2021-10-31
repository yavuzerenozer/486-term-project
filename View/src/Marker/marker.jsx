import React from "react";
import marker0 from "./marker0.png";


const Marker = (props) => {
  const markers = [marker0];
  return (
    <div>
      <img
        src={markers[0]}
        alt="Instructions"
        style={{
          padding: "15px 10px",
          display: "inline-flex",
          alignItems: "center",
          justifyContent: "center",
          transform: "translate(-50%, -50%)",
        }}
      ></img>
    </div>
  );
};

export default Marker;