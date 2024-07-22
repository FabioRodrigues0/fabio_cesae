// eslint-disable-next-line no-unused-vars
import React from "react";
import "./newsCard.style.css";
import {Card, Col} from "react-bootstrap";
import NewsCardModal from "../newsCardModal/newsCardModal.jsx";

export const NewsCard = (card, index) => {

    const [modalShow, setModalShow] = React.useState(false);

    return (
            <Col sm={4} key={index}>
                {/*style={{width: '18rem'}}*/}
                <Card className="card-ajust" onClick={() => setModalShow(true)}>
                    <Card.Img variant="top" src={card.imageSrc} width={200} height={200} className="img-ajust"/>
                    <Card.Body>
                        <Card.Title>{card.title}</Card.Title>
                        <Card.Text>
                            {card.description}
                        </Card.Text>
                        <time className="text-muted date-cards">{card.date}</time>
                    </Card.Body>
                </Card>
                <NewsCardModal
                    modalTitle={card.title}
                    modalImage={card.imageSrc}
                    modalDescription={card.description}
                    modalDate={card.date}
                    show={modalShow}
                    onHide={() => setModalShow(false)}
                />
            </Col>
        );
};

export default NewsCard;
