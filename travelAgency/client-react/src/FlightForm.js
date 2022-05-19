import React from  'react';

class FlightForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            id: "",
            start: "",
            destination: "",
            startDate: "",
            nrOfSeats: ""
        };
    }

    handleStartChange = (event) => {
        this.setState({start: event.target.value});
    }

    handleDestinationChange = (event) => {
        this.setState({destination: event.target.value});
    }

    handleStartDateChange = (event) => {
        this.setState({startDate: event.target.value});
    }

    handleNrOfSeatsChange = (event) => {
        this.setState({nrOfSeats: event.target.value});
    }

    handleSubmit = (event) => {
        let flight = {
            name:this.state.name,
            passwd:this.state.passwd
        }
        console.log('A user was submitted: ');
        console.log(user);
        this.props.addFunc(user);
        event.preventDefault();
    }
}