// eslint-disable-next-line no-unused-vars
import React from 'react';
import "./telahome.css";

export default function First(){
    return(
        <div className="all">
            <div className="containers">
                <div className="container1">
                    <div>
                        <h1 className="titles">Para Hoje</h1>
                        <p>Estimativa: 1h</p>
                        <hr />  
                        <p>Itens</p>
                        <div className="flashCard">
                            <div className="flashCards">
                                <p className="titles">indices</p>
                                <hr />
                                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Odit quis neque ducimus a soluta aliquid amet rerum accusamus, fuga veniam maiores, dolor architecto rem odio quo perspiciatis similique quisquam quod.</p>
                            </div>
                            <div className="flashCards">
                                <p className="titles">Flashcards</p>
                                <hr />
                                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Odit quis neque ducimus a soluta aliquid amet rerum accusamus, fuga veniam maiores, dolor architecto rem odio quo perspiciatis similique quisquam quod.</p>
                            </div>
                            <div className="flashCards">
                                <p className="titles">Deadlocks</p>
                                <hr />
                                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Odit quis neque ducimus a soluta aliquid amet rerum accusamus, fuga veniam maiores, dolor architecto rem odio quo perspiciatis similique quisquam quod.</p>
                            </div>
                            <div className="flashCards">
                                <p className="titles">Case sensitive</p>
                                <hr />
                                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Odit quis neque ducimus a soluta aliquid amet rerum accusamus, fuga veniam maiores, dolor architecto rem odio quo perspiciatis similique quisquam quod.</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container2">
                    <div>
                        <h1 className="titles">Progresso Geral</h1>
                        <br />  
                        <hr />  
                        <p>Taxa de acerto</p>
                        <div className="flashCard">
                            <img src="Capturar.PNG" alt="" />
                        </div>
                        <div className="flashCardsDicas">
                            <p className="titles">Dicas</p>
                            <hr />
                            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Odit quis neque ducimus a soluta aliquid amet rerum accusamus, fuga veniam maiores, dolor architecto rem odio quo perspiciatis similique quisquam quod.</p>
                        </div>
                    </div>
                </div>
            </div> 
            <footer className="footer">
                <div className="imgesquerda">
                    <a href="">
                        <img className="img" src="icone.config.png" alt="" />
                    </a>
                    <a href="">
                        <img className="img" src="icone.perfil.png" alt="" />
                    </a>
                    <a href="">
                        <img className="img" src="icone.lua.png" alt="" />
                    </a>
                </div>
                <div className="imgcenter">
                    <a href="">
                        <img className="img" src="icone.doc.png" alt="" />
                    </a>
                    <a href="">
                        <img className="img" src="icone.lista.png" alt="" />
                    </a>
                    <a href="">
                        <img className="img" src="icone.trevo.png" alt="" />
                    </a>
                    <a href="">
                        <img className="img" src="icone.bandeira.png" alt="" />
                    </a>
                </div>
                <div className="imgdireita">
                    <a href="">
                        <img className="img" src="icone.wp.png" alt="" />
                    </a>
                </div>
            </footer>
        </div>
    )
}
