import { Link } from 'react-router-dom';

export default function FlashCard(){
    return(
        <div className="allfc">
            <section className="containersfc">
            <div className="container1fc">
                <div className="header">
                <div className="para_hojefc">
                    <a href="">
                        <img className="imgvoltar"src="Voltar.PNG" alt="" />
                    </a>
                    <h1 className="titlesfc">Mongo DB</h1>
                </div>
                <div className="buttonfc">
                    <button className="button2fc">
                        <h2 >Adicionar FlashCard</h2>
                    </button>
                </div> 
                </div> 
                <hr />    
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
                        <Link to = "/flashCard">
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