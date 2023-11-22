import { Link } from 'react-router-dom';

export default function FlashCard() {
    return (
        <div className="allfc">
            <section className="containersfc">
                <div className="container1fc">
                    <div className="header">
                        <div className="para_hojefc">
                            <Link to="/studyspace">
                                <img className="imgvoltar" src="Voltar.PNG" alt="Voltar" />
                            </Link>
                            <h1 className="titlesfc">Mongo DB</h1>
                        </div>
                        <div className="buttonfc">
                            <button className="button2fc">
                                <h2>Adicionar FlashCard</h2>
                            </button>
                        </div>
                    </div>
                    <hr />
                </div>
            </section>
            <footer className="footer">
                <div className="imgesquerda">
                    <Link to="/telaconfig">
                        <img className="img" src="icone.config.png" alt="Configurações" />
                    </Link>
                    <Link to="/profile">
                        <img className="img" src="icone.perfil.png" alt="Perfil" />
                    </Link>
                    <a href="">
                        <img className="img" src="icone.lua.png" alt="Lua" />
                    </a>
                </div>
                <div className="imgcenter">
                    <Link to="/studyspace">
                        <img className="img" src="icone.doc.png" alt="Estudos" />
                    </Link>
                    <Link to="/flashCard">
                        <img className="img" src="icone.lista.png" alt="Lista" />
                    </Link>
                    {/* Replace with valid href or convert to Link */}
                    <a href="">
                        <img className="img" src="icone.trevo.png" alt="Trevo" />
                    </a>
                    <a href="">
                        <img className="img" src="icone.bandeira.png" alt="Bandeira" />
                    </a>
                </div>
                <Link to="/telahome">
                    <img className="img" src="icone.wp.png" alt="Home" />
                </Link>
            </footer>
        </div>
    )
}
