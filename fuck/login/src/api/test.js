import axios from 'axios'
import qs from 'qs'

export const login = params =>{
  return axios.post('/api/user/login',qs.stringify(params));
}
