import React, { useState } from 'react';
import PropTypes from 'prop-types';
import './pupupstudycss.css';

const PopupStudy = ({ categoryName, setCategoryName, onSave }) => {

    return (
        <div style={{
            zIndex: 1000,
        }}>
        <div className="popup-background">
            <div className="popup-container" >
                <div className="popup-content" >
                    <input
                        type="text"
                        placeholder="categoria"
                        value={categoryName}
                        onChange={e => setCategoryName(e.target.value)}
                    />
                    <button onClick={onSave}>Confirmar</button>
                </div>
            </div>
        </div>
        </div>
    );
};

PopupStudy.propTypes = {
    newCard: PropTypes.shape({
        categoria: PropTypes.string,
    }).isRequired,
    setNewCard: PropTypes.func.isRequired,
    onSave: PropTypes.func.isRequired
};

export default PopupStudy;
