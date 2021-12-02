import React, { Component } from "react";
import Item from "../../components/Item";
import Button from "../../components/button";
import Modal from "../../components/modal";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Search from "../../components/search";

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [/*
                {
                    id: 1,
                    title: "Nintendo Switch",
                    price: "Rp5.000.000",
                    description: "The video game system you can play at home or on the go.",
                    category: "Console",
                    quantity: "100",
                },
        {
            id: 2,
            title: "Playstation 5",
            price: "Rp12.000.000",
            description: "A home video game console developed by Sony Interactive Entertainment.",
            category: "Console",
            quantity: "100",
        },
        {
            id: 3,
            title: "ASUS ROG Zephyrus G14",
            price: "Rp17.000.000",
            description: "ASUS ROG Zephyrus G14 is a successful equipment for work and entertainment.",
            category: "Laptop",
            quantity: "100",
        }
        */],
        isLoading: false,
        isCreate: false,
        isEdit: false,
        search:"",
        id: "",
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0
    };
    this.handleClickLoading = this.handleClickLoading.bind(this);
    this.handleAddItem = this.handleAddItem.bind(this);
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.loadData = this.loadData.bind(this);
    this.handleSubmitItem = this.handleSubmitItem.bind(this);
    this.handleEditItem = this.handleEditItem.bind(this);
    this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
    this.handleSearch = this.handleSearch.bind(this);
    }

    /*componentDidMount() {
        console.log("componentDidMount()");
    }*/
    componentDidMount() {
        this.loadData();
    }
    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }
    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    handleAddItem() {
        this.setState({ isCreate:true });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate:false, isEdit:false });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            console.log(data);
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0,
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleSearch(event){
        event.preventDefault();
        this.setState({search: event.target.value});
        console.log(this.state.search);
    }

    render() {
        let filteredItems = this.state.items.filter(
            (item) => {
                return item.title.toLowerCase()
                        .indexOf(this.state.search.toLowerCase()) !== 1;
            }
        )
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>All Items</h1>
                <Button action={this.handleAddItem}>
                    Add Item
                </Button>
                <Search
                    actions = {this.handleSearch}
                    searchField = {this.state.search}
                >
                </Search>
                <div className="container pt-3">
                    <div className="row mt-3">
                        {!this.state.cartHidden ? (
                            <div className="col-sm">
                                <List
                                    /*title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={() => {}}*/
                                    title="My Cart"
                                    items={this.state.cartItems}
                                    onItemClick={this.handleDeleteItemFromCart}
                                    isShopList={false}
                                ></List>
                            </div>
                        ) : <div className="col-sm">
                            <List
                                title="List Items"
                                items={this.state.shopItems}
                                onItemClick={this.handleAddItemToCart}
                                isShopList={true}
                            ></List>
                        </div>}
                    </div>
                </div>
                <div>
                    {filteredItems.map((item) => (
                        <Item
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            price={item.price}
                            description={item.description}
                            category={item.category}
                            quantity={item.quantity}
                        />
                    ))}
                </div>
                <Modal
                    show={this.state.isCreate || this.state.isEdit}
                    handleCloseModal={this.handleCancel}
                    modalTitle={this.state.isCreate
                ? "Add Item"
                : `Edit Item ID ${this.state.id}`}
                >
                    <form>
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Item"
                            name="title"
                            value={this.state.name}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="number"
                            placeholder="Harga"
                            name="price"
                            value={this.state.price}
                            onChange={this.handleChangeField}
                        />
                        <textarea
                            className={classes.textField}
                            placeholder="Deskripsi"
                            name="description"
                            rows="4"
                            value={this.state.description}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Kategori"
                            name="category"
                            value={this.state.category}
                            onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField}
                            type="number"
                            placeholder="qty"
                            name="quantity"
                            value={this.state.quantity}
                            onChange={this.handleChangeField}
                        />
                        <Button action={this.state.isCreate
                            ? this.handleSubmitItem
                            : this.handleSubmitEditItem}
                        >
                            Create
                        </Button>
                        <Button action={this.handleCancel}>
                            Cancel
                        </Button>
                    </form>
                </Modal>
            </div>
        );
    }
}
export default ItemList;
