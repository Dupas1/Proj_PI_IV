import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import "./client/telahome/telahome.css"
import "./client/telaconfig/config.css"
import "./client/telaperfil/perfil.css"
import "./client/login/login.css"
import "./client/studyspace/study.css"

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
)
