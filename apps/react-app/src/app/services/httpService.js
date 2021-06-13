import axios from 'axios';
import {toast} from 'react-toastify';

axios.defaults.baseURL = 'http://localhost:6969';

axios.interceptors.response.use(null, (error) => {
    console.log('Interceptor called');
    const expectedError =
        error.response &&
        error.response.status >= 400 &&
        error.response.status < 500;

    if (!expectedError) {
        toast.error('Unexpected error occured.');
        console.log('Logging Unexpected Error ', error);
    }
    return Promise.reject(error);
});

export default {
    get: axios.get,
    delete: axios.delete,
    post: axios.post,
    put: axios.put,
};