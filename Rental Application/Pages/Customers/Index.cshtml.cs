using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Microsoft.EntityFrameworkCore;
using RazorPagesRental.Data;
using RazorPagesRental.Models;

namespace RazorPagesRental.Pages_Customers
{
    public class IndexModel : PageModel
    {
        private readonly RazorPagesRental.Data.RazorPagesCustomersContext _context;

        public IndexModel(RazorPagesRental.Data.RazorPagesCustomersContext context)
        {
            _context = context;
        }

        public IList<Customers> Customers { get;set; } = default!;

        [BindProperty(SupportsGet = true)]
        public string? SearchString { get; set; }

        public async Task OnGetAsync()
        {
            var customers = from m in _context.Customers
                 select m;
            if (!string.IsNullOrEmpty(SearchString))
            {
                customers = customers.Where(s => s.Email.Contains(SearchString));
            }

            Customers = await customers.ToListAsync();
        }
    }
}
