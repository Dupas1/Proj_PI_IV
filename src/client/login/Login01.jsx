/* eslint-disable no-unused-vars */
// Importe Component da biblioteca 'react'
import React, { Component } from 'react'; 
import './login.css'; 
import logo from '/public/logoWood.png';


class Login01 extends Component {
    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: ''
        };

        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.mensagemtemporaria = this.mensagemtemporaria.bind(this);
    }

    mensagemtemporaria() {
        alert('Carregando...');
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    handleSubmit(event) {
        event.preventDefault(); // Isso impede o comportamento padrão do formulário de recarregar a página.
        console.log('Login submitted:', this.state);
    }

    render() {
        return (
            <div className="container">
                <div className="left-side">
                    {/* Conteúdo do lado esquerdo (se necessário) pode ser adicionado aqui */}
                </div>
                <div className="right-side">
                    <img src={logo} alt="Woodpeacker Logo" className="logo" />
                    <p className="greeting-1">OLÁ USUÁRIO!</p>
                    <p className="greeting-2">Eu sou seu assistente inteligente para cuidar da sua memória</p>
                    <div className="login-form">
                        <form onSubmit={this.handleSubmit}>
                            <div className="form-group">
                                <input
                                    type="text"
                                    name="email"
                                    placeholder="Email"
                                    value={this.state.email}
                                    onChange={this.handleInputChange}
                                    required
                                />
                            </div>
                            <div className="form-group">
                                <input
                                    type="password"
                                    name="password"
                                    placeholder="Senha"
                                    value={this.state.password}
                                    onChange={this.handleInputChange}
                                    required
                                />
                            </div>
                            <div className="button-group">
                                {/* O botão 'submit' deve estar dentro da tag <form> para disparar o evento onSubmit */}
                                <button type="submit">ENTRAR</button>
                                <button type="button">CADASTRAR-SE</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

export default Login01; // Exportando o componente Login01.
