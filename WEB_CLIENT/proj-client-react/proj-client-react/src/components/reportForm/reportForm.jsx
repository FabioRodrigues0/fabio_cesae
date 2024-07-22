// eslint-disable-next-line no-unused-vars
import React from "react";
import "./reportForm.style.css";
import {PopupSubmit} from "../popupSubmit/popupSubmit.jsx";
import {Form} from "react-bootstrap";
import Button from "react-bootstrap/Button";

export const ReportForm = () => {
    const [modalShow, setModalShow] = React.useState(false);
    const [validated, setValidated] = React.useState(false);

    const handleSubmit = (event) => {
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();

        }else {
            setModalShow(true);
        }
        setValidated(true);
    };

    return (
        <div className="row m-3">
            <div className="col-md-12 order-md-1">
                <h4 className="mb-3">Report</h4>
                <Form noValidate validated={validated} onSubmit={handleSubmit}>
                    <Form.Group className="mb-3" controlId="formTitle">
                        <Form.Label>Titulo</Form.Label>
                        <Form.Control type="text" placeholder="Titulo da Noticia" required/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formLinkImage">
                        <Form.Label>Link Imagem</Form.Label>
                        <Form.Control type="text" placeholder="Link da Imagem da Noticia" required/>
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="formDescription">
                        <Form.Label>Descrição</Form.Label>
                        <Form.Control as="textarea" rows={3} required/>
                    </Form.Group>
                    <Button variant="primary" className="float-end" type="submit">
                        Submit
                    </Button>
                </Form>
            </div>
            <PopupSubmit
                show={modalShow}
                onHide={() => setModalShow(false)}
            />
        </div>

    );
};

export default ReportForm;
