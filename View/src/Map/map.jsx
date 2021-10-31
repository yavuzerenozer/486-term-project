import React, { useState, useEffect } from 'react';
import { getEarthquakes } from '../API/apiCall';
import Loader from 'react-loader-spinner';
import GoogleMapReact from 'google-map-react';
import Marker from '../Marker/marker';


export default function Map(props) {
    const [isLoading, setIsloading] = useState(false);
    const [earthquakes, setEarthquakes] = useState([]);
    const [defaultCenter, setDefaultCenter] = useState([39,34.5]);
    const [zoom, setZoom] = useState(6);
    const [APIkey, setAPIkey] = useState("YourGoogleMapsAPIKey");


    useEffect(() => {
        getEarthquakes().then(res => {
            setEarthquakes(res);
        });
        
    }, [earthquakes])
    
    if(earthquakes.length<1) return (
        <div style= {{display: 'flex', justifyContent:'center' , alignItems: 'center', height: '100vh'}}>
          <Loader
            type="ThreeDots"
            color="#18265b"
            height={100}
            width={100}
            timeout={10000} //10 secs
          />
        </div>
    )

    


    else {
        const data = earthquakes.map((place) => ({
            lat: place.lat,
            lng: place.lng,
            weight: 1,
          }));
    
        const heatmap = {
            positions: data,
            options: {
                radius: 30,
                opacity: 0.7,
            }
        };
        return (
        <div style={{ height: '100vh', width: '100%' }}>
        <GoogleMapReact
            apiKey = {APIkey}
            defaultZoom = {zoom}
            defaultCenter = {defaultCenter}
            heatmap={heatmap}
            bootstrapURLKeys={{
                key: APIkey,
                libraries: ["visualization"],
            }}
        >
            {/* {earthquakes.map((earthquake) => (
                    <Marker
                      key={earthquake.lat}
                      lat={parseFloat(earthquake.lat)}
                      lng={parseFloat(earthquake.lng)}
                      selectedMarker={0}
                    />
                  ))} */}
        </GoogleMapReact>
        </div>
        

    );
            }



}
