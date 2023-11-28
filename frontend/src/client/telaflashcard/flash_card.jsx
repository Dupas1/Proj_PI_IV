// FlashCard.js
// eslint-disable-next-line no-unused-vars
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Popup from './popup'; // Importando o componente Popu

export default function FlashCard() {
    const [flashCards, setFlashCards] = useState([]);
    const [showPopup, setShowPopup] = useState(false);
    const [newCard, setNewCard] = useState({ tipo: '', pergunta: '', resposta: '' });

    const handleAddCard = () => {
        setFlashCards([...flashCards, newCard]);
        setNewCard({ tipo: '', pergunta: '', resposta: '' });
        setShowPopup(false);
    };

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
                            <button className="button2fc" onClick={() => setShowPopup(true)}>
                                <h2>Adicionar FlashCard</h2>
                            </button>
                        </div>
                    </div>
                    <hr />
                    {showPopup && (
                        <Popup 
                            newCard={newCard} 
                            setNewCard={setNewCard} 
                            onSave={handleAddCard}
                        />
                    )}

                    <div className="flashcard-container">
                {flashCards.map((card, index) => (
                    <div key={index} className="flashcard">
                        <p>Tipo: {card.tipo}</p>
                        <p>Pergunta: {card.pergunta}</p>
                        <p>Resposta: {card.resposta}</p>
                    </div>
                ))}
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
    );
}
