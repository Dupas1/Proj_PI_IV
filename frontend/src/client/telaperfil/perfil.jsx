import { Link } from 'react-router-dom';

export default function Prof() {
  return (
    <div className="allp">
      <section className="containersp">
        <div className="container1p">
          <div className="imgperfilp">
            <img src="Ellipse 37.png" alt="" className="imgelip" />
            <img src="person.png" alt="" className="image-overlayp" />
          </div>
          <div className="dadosp">
            <h1 className="h1p">Nome: </h1>
            <p></p>
            <h1 className="h1p">Email: </h1>
            <p></p>
            <h1 className="h1p">Telefone: </h1>
            <p></p>
            <h1 className="h1p">Genêro: </h1>
            <p></p>
            <h1 className="h1p">Data de entrada: </h1>
            <p></p>
          </div>
          <div className="buttonsp">
            <button className="button1p">
              <h2 className="h2p">Editar</h2>
            </button>
            <button className="button2p">
              <h2 >Gerenciar conta</h2>
            </button>
          </div>
        </div>
        <div className="container2p">

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
            <Link to="/flashCard">
              <img className="img" src="icone.lista.png" alt="" />
            </Link>
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
