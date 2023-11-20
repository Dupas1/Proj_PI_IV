/* eslint-disable react/no-deprecated */
import React from "react";
import ReactDOM from "react-dom";
import Login01 from './client/login/Login01'; 
import Studyspace from "./client/studyspace/study01";
import First from './client/telahome/tela_home'; 



class LoginPrincipal extends React.Component{
    render(){
        return(
            <div>
               <Login01/>
               <Studyspace/> 
               <First/>

            
            </div>
        )
    }
}


ReactDOM.render(<LoginPrincipal/>, document.getElementById('root'));