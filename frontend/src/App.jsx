import Prof from "./client/telaperfil/perfil.jsx"
import { BrowserRouter as Router , Routes , Route } from 'react-router-dom'
import Login from "./client/login/Login01.jsx"
import Studyspace from "./client/studyspace/study01.jsx"
import Config from "./client/telaconfig/config.jsx"
import First from "./client/telahome/tela_home.jsx"
import FlashCard from "./client/telaflashcard/flash_card.jsx"
import Cadastro from "./client/cadastro/cadastropage.jsx"

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
                <Route path='/cadastropage' element = {<Cadastro/>}/>
            </Routes>
        </Router>
    </div>
  )
}

export default App
