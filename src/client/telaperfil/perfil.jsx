import { Link } from 'react-router-dom';

export default function Prof(){
    return(
        <div className="all">
        <section className="containers">
            <div className="container1">
                <div className="imgperfil">
                    <img src="Ellipse 37.png" alt="" className="imgeli"/>
                    <img src="person.png" alt="" className="image-overlay"/>
                </div>
                <br />
                <div className="dados">
                    <h1>Nome: </h1>
                    <p></p>
                </div>
                <div className="dados">
                    <h1>Email: </h1>
                    <p></p>
                </div>
                <div className="dados">
                    <h1>Telefone: </h1>
                    <p></p>
                </div>
                <div className="dados">
                    <h1>Genêro: </h1>
                    <p></p>
                </div>
                <div className="dados">
                    <h1>Data de entrada: </h1>
                    <p></p>
                </div>
                <div className="buttons">
                <button className="button1">
                    <h2>Editar</h2>
                </button>
                <button className="button2">
                    <h2>Gerenciar conta</h2>
                </button>
                </div>
            </div>
            <div className="container2">
                
            </div>
        </section>
        <footer className="footer">
      <div className="imgesquerda"> 
        <div>
          <Link to="/telaconfig">
            <img className="img" src="icone.config.png" alt="" />
          </Link>
        </div>
        <div>
          <Link to="/profile">
            <img className="img" src="icone.perfil.png" alt="" />
          </Link>
        </div>
        <div>
          <a href="">
            <img className="img" src="icone.lua.png" alt="" />
          </a>
        </div>
      </div>
      <div className="imgcenter">
        <div>
          <Link to="/studyspace">
            <img className="img" src="icone.doc.png" alt="" />
          </Link>
        </div>
        <div>
          <a href="">
            <img className="img" src="icone.lista.png" alt="" />
          </a>
        </div>
        <div>
          <a href="">
            <img className="img" src="icone.trevo.png" alt="" />
          </a>
        </div>
        <div>
          <a href="">
            <img className="img" src="icone.bandeira.png" alt="" />
          </a>
        </div>
      </div>
      <div className="imgdireita">
        <a href="">
          <Link to="/telahome"> 
            <img className="img" src="icone.wp.png" alt="" />
          </Link>
        </a>
      </div>
    </footer>
        </div>
    )
}
