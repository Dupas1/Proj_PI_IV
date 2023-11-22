import Prof from "./client/telaperfil/perfil.jsx"
import { BrowserRouter as Router , Routes , Route } from 'react-router-dom'
import Login from "./client/login/Login01.jsx"
import Studyspace from "./client/studyspace/study01.jsx"
import Config from "./client/telaconfig/config.jsx"
import First from "./client/telahome/tela_home.jsx"
import FlashCard from "./client/telafalshcard/flash_card.jsx"

function App(){
  return(
    <div className="app">
      <Router>
            <Routes>
                <Route path='/' element = {<Login />} />
                <Route path='/studyspace' element = {<Studyspace />} />
                <Route path='/telaconfig' element = {<Config />} />
                <Route path='/telahome' element = {<First />} />
                <Route path='/profile' element = {<Prof />} />
                <Route path='/flashCard' element = {<FlashCard/>}/>
            </Routes>
        </Router>
    </div>
  )
}

export default App
