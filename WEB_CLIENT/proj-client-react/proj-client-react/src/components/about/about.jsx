// eslint-disable-next-line no-unused-vars
import React from "react";
import "./about.style.css";

export const About = () => {
    return (
        <div className="container my-4 about-ajust" id="about">
            <div className="row mt-4 pe-lg-0 pt-lg-5 align-items-center rounded-3 border about-ajust-items">
                <div className="col-lg-7 p-3 p-lg-5 pt-lg-3">
                    <h1 className="display-4 fw-bold lh-1">Sobre Nós</h1>
                    <h3>Bem-vindo ao Tugão News</h3>
                    <p className="lead">No Tugão News, nossa missão é mantê-lo informado sobre as últimas novidades e
                        tendências do mundo da tecnologia. Desde avanços inovadores em inteligência artificial até as
                        mais recentes atualizações em gadgets e software, estamos aqui para fornecer análises
                        aprofundadas e notícias confiáveis.</p>
                </div>
                <div className="col-lg-4 offset-lg-1 p-0 overflow-hidden about-div-img-ajust">
                    <img className="rounded-lg-3 about-img-ajust" src="https://images.unsplash.com/photo-1497366754035-f200968a6e72?q=80&w=2069&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="" width="720"/>
                </div>
            </div>
            <div className="row mt-4 pe-lg-0 pt-lg-5 align-items-center rounded-3 border about-ajust-items">
                <div className="col-lg-7 p-3 p-lg-5 pt-lg-3">
                    <h1 className="display-4 fw-bold lh-1">Quem Somos</h1>
                    <p className="lead">Somos uma equipe apaixonada por tecnologia, composta por jornalistas
                        experientes, analistas e
                        entusiastas do setor. Acreditamos que a tecnologia tem o poder de transformar vidas e queremos
                        compartilhar essa jornada com você.</p>
                </div>
                <div className="col-lg-4 offset-lg-1 p-0 overflow-hidden about-div-img-ajust">
                    <img className="rounded-lg-3 about-img-ajust" src="https://images.unsplash.com/photo-1517048676732-d65bc937f952?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="" width="720"/>
                </div>
            </div>
            <div className="row mt-4 pe-lg-0 pt-lg-5 align-items-center rounded-3 border about-ajust-items">
                <div className="col-lg-7 p-3 p-lg-5 pt-lg-3">
                    <h1 className="display-4 fw-bold lh-1">O Que Fazemos</h1>
                    <p className="lead">No Tugão News, cobrimos uma ampla gama de tópicos tecnológicos,
                        incluindo:</p>
                    <ul>
                        <li><b>Inteligência Artificial:</b> Descubra como a IA está moldando o futuro.</li>
                        <li><b>Gadgets e Dispositivos:</b>Fique por dentro das últimas inovações em smartphones,
                            wearables, e muito mais.
                        </li>
                        <li><b>Software e Aplicativos:</b>Análises detalhadas e notícias sobre os softwares que
                            facilitam o seu dia a dia.
                        </li>
                        <li><b>Segurança Cibernética:</b>Dicas e notícias para manter seus dados seguros.</li>
                        <li><b>Startups e Inovação:</b>Acompanhe as histórias de startups que estão revolucionando
                            o setor.
                        </li>
                    </ul>
                </div>
                <div className="col-lg-4 offset-lg-1 p-0 overflow-hidden about-div-img-ajust">
                    <img className="rounded-lg-3 about-img-ajust" src="https://images.unsplash.com/photo-1551434678-e076c223a692?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="" width="720"/>
                </div>
            </div>
            <div className="row mt-4 pe-lg-0 pt-lg-5 align-items-center rounded-3 border about-ajust-items">
                <div className="col-lg-7 p-3 p-lg-5 pt-lg-3">
                    <h1 className="display-4 fw-bold lh-1">Nossa Visão</h1>
                    <p className="lead">Queremos ser a sua principal fonte de informações sobre tecnologia, ajudando
                        você a entender as mudanças rápidas e significativas no setor. Nosso objetivo é proporcionar
                        conteúdo de alta qualidade que informe, inspire e capacite nossos leitores.</p>
                </div>
                <div className="col-lg-4 offset-lg-1 p-0 overflow-hidden about-div-img-ajust">
                    <img className="rounded-lg-3 about-img-ajust" src="https://images.unsplash.com/photo-1516062423079-7ca13cdc7f5a?q=80&w=2083&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="" width="720"/>
                </div>
            </div>
        </div>
    );
};

export default About;