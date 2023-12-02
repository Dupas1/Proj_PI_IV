// Popup.js
// eslint-disable-next-line no-unused-vars
import React from 'react';
import PropTypes from 'prop-types';
import './pupupcss.css';

const Popup = ({ newCard, setNewCard, onSave }) => {
    return (
        <div className="popup-background">
            <div classname ="popup-container">
                <div className="popup-content">
                <input 
                    type="text"
                    placeholder="Tipo"
                    value={newCard.tipo}
                    onChange={(e) => setNewCard({ ...newCard, tipo: e.target.value })}
                />
                <input 
                    type="text"
                    placeholder="Pergunta"
                    value={newCard.pergunta}
                    onChange={(e) => setNewCard({ ...newCard, pergunta: e.target.value })}
                />
                <input 
                    type="text"
                    placeholder="Resposta"
                    value={newCard.resposta}
                    onChange={(e) => setNewCard({ ...newCard, resposta: e.target.value })}
                />
                <button
                    onClick={onSave}>Confirmar
                </button>
                </div>
            </div>
        </div>
    );
};


Popup.propTypes = {
    newCard: PropTypes.shape({
        tipo: PropTypes.string,
        pergunta: PropTypes.string,
        resposta: PropTypes.string
    }).isRequired,
    setNewCard: PropTypes.func.isRequired,
    onSave: PropTypes.func.isRequired
};

export default Popup;
