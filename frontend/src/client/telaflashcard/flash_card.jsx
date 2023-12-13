// FlashCard.js
// eslint-disable-next-line no-unused-vars
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import Popup from './popup';
import './flash_card.css';
import { useParams } from 'react-router-dom';
import api from '../../services/api';

export default function FlashCard() {
    const params = useParams();
    const [flashCards, setFlashCards] = useState([]);
    const [showPopup, setShowPopup] = useState(true);
    const [newCard, setNewCard] = useState({ tipo: params.categoryName, pergunta: '', resposta: '' });

    const handleAddCard = async() => {
        try {
            if (newCard.pergunta.trim().length === 0 || newCard.resposta.trim().length === 0 ) return;
            if(params.categoryId === null) window.location.href = '/studyspace';
            const response = await api.post(`/flashcard/${params.categoryId}`, {
                question: newCard.pergunta,
                answer: newCard.resposta,
            });    
            setFlashCards([...flashCards, response.data]);
            setNewCard({ tipo: params.categoryName, pergunta: '', resposta: '' });
            setShowPopup(false);
        } catch (error) {
            console.log(error);
        }
    };

    const getFlashCards = async() => {
        console.log("chamando lista de flashcard")
        console.log(params.categoryId);
        const response = await api.get(`/flashcard/${params.categoryId}`);
        console.log("Flashcards list",response.data);
        setFlashCards(response.data);

    };

    useEffect(()=>{
        getFlashCards();
    },[])

    return (
        <div className="allfc">
            <section className="containersfc">
                <div className="container1fc">
                    <div className="header">
                        <div className="para_hojefc">
                            <Link to="/studyspace">
                                <img className="imgvoltar" src="Voltar.PNG" alt="Voltar" />
                            </Link>
                            <h1 className="titlesfc"></h1>
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
                        {flashCards.length > 0 && flashCards.map((card, index) => (
                            <div key={index} className="flashcard">
                                <p>Tipo: {params.categoryName}</p>
                                <p>Pergunta: {card.question}</p>
                                <p>Resposta: {card.answer}</p>
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
