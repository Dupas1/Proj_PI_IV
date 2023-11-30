// eslint-disable-next-line no-unused-vars
import React from 'react';
import "./telahome.css";
import { Link } from 'react-router-dom';

export default function First() {
    return (
        <div className="allth">
            <section className="containersth"
            ><div className="container1th">
                    <div className="para_hojeth">
                        <h1 className="titlesth">Para Hoje</h1>
                        <p1>Estimativa: 1h</p1>
                        <hr />
                        <p1>Itens</p1>
                        <div className="flashCardth">
                        </div>
                    </div>
                </div>
                <div className="container2th">
                    <div className="progresso_geralth">
                        <h1 className="titlesth">Progresso Geral</h1>
                        <br />
                        <hr />
                        <p1>Taxa de acerto</p1>
                        <div className="flashCardth">
                        </div>
                    </div>
                </div>
                <div className="container3th">
                    <div className="ideiasth">
                        <h1 className="dtitlesth">Dica do Dia</h1>
                        <div className="flashCardth">
                        </div>
                    </div>
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