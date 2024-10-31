import { useEffect, useState } from 'react';
import './App.css';
import axios from 'axios';

function App() {
  const [count, setCount] = useState(0)
  useEffect(()=>{
    console.log(count)
    // axios.get("http://localhost:8080/count")
    // .then((resp)=>{setCount(resp.data)})
    // .catch((error)=>{console.log(error)})
    axios.post("http://localhost:8080/count", {count : count})
    .catch((error)=>{console.log(error)})
  },[count])
  return (
    <>
    <div id="count">{count}</div>
    <div id="btnbox">
      <div className='btn' onClick={()=>{setCount(count-1)}}>-</div>
      <div className='btn' onClick={()=>{setCount(0)}}>0</div>
      <div className='btn' onClick={()=>{setCount(count+1)}}>+</div>
    </div>
    </>
  );
}

export default App;