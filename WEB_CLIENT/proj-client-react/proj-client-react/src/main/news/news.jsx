// eslint-disable-next-line no-unused-vars
import React from "react";
import "./news.style.css";
import {Items} from '../../data/data.js';
import {Container, Row} from "react-bootstrap";
import {NewsCard} from "../../components/newsCard/newsCard.jsx";

export const News = () => {
    // eslint-disable-next-line react/prop-types
    const cardInfo = Items;

    return (
        <section id="news">
            <Container className="mt-3 news-ajust">
                <Row xs={1} md={4} className="g-2">
                    {cardInfo.map(NewsCard)}
                </Row>
            </Container>)
        </section>
    );
};

export default News;