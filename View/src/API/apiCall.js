import axios from "axios";

export async function getEarthquakes() {

    let array = [];
    await axios
    .get('http://localhost:8080/api/')
    .then((response) => {
        array = response.data
    })
    return array;
}