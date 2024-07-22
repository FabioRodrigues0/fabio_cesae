// eslint-disable-next-line no-unused-vars
import React from "react";
import "./navbar.style.css";
import logo from "../../assets/logo.png";
import {Container, Nav, Navbar} from "react-bootstrap";

export const NavHeader = () => {

    return (
        <Navbar bg="dark" data-bs-theme="dark" className="bg-body-tertiary">
            <Container>
                <Navbar.Brand href="/">
                    <img
                        alt=""
                        src={logo}
                        width="30"
                        height="30"
                        className="d-inline-block align-top me-sm-2"
                    />Tugão News
                </Navbar.Brand>
                <Navbar.Collapse className="justify-content-end">
                    <Nav className="me-auto">
                        <Nav.Link href="/">Home</Nav.Link>
                        <Nav.Link href="/#about">About</Nav.Link>
                        <Nav.Link href="/news">News</Nav.Link>
                        <Nav.Link href="/reports">Report</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};
