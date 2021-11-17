import axios from "axios";

async function getEarthquakes0() {

    return fetch('http://localhost:8080/api/', {
    method: "GET",
    headers: {"Content-Type": "application/json"}
  }).then((res) => {
    
    res.json()  
    
  })
}

async function getNews0(searchTerm) {
    return fetch(`http://localhost:8080/news?term=${searchTerm}`, {
    method: "GET",
    headers: {"Content-Type": "application/json"}
  }).then(res => res.json())
}


///////////////////////FACADE APPLIED//////////////////////



async function getEarthquakes1() {
    return getFetch1('http://localhost:8080/api/')
}

async function getNews1(searchTerm) {
    return getFetch1('http://localhost:8080/news',
    {searchTerm: searchTerm})
}

async function getFetch1(url, params = {}) {
  const query = Object.entries(params).map(param => {
    return `${param[0]}=${param[1]}`
  }).join('&')

  return fetch(`${url}?${query}`, {
    method: "GET",
    headers: {"Content-Type": "application/json"}
  }).then(res=>res.json)
}

//////////////USE CASE: CHANGE OF HTTP CLIENT//////////////



export async function getEarthquakes(){
  return getFetch('http://localhost:8080/api/')
}

export async function getNews(searchTerm) {
  return getFetch('http://localhost:8080/news', {searchTerm: searchTerm})
}

async function getFetch(url, params = {}) {
  return axios ({
    url:url,
    method: "GET",
    params:params
  }).then(res=>res.data)
}




