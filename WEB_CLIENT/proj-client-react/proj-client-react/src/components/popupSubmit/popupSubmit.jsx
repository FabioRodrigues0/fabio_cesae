import "./popupSubmit.style.css";
import Modal from 'react-bootstrap/Modal';

export function PopupSubmit(props) {
    return (
        <Modal{...props} size="lg" aria-labelledby="contained-modal-title-vcenter" className="bg-success" centered>
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Submitdo
                </Modal.Title>
            </Modal.Header>
            <Modal.Body className="card-no-border card flex-md-row border-success mb-4">
                <div className="card-body d-flex flex-column align-items-start">
                    <p className="card-text mb-auto">Obrigado pela Submição da Noticia</p>
                </div>
            </Modal.Body>
            <Modal.Footer>
                {/* eslint-disable-next-line react/prop-types */}
            </Modal.Footer>
        </Modal>
    );
}

export default PopupSubmit;